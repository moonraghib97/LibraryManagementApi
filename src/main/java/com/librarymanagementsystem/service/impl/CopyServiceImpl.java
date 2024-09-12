package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.dto.CopyDTO;
import com.librarymanagementsystem.entities.Book;
import com.librarymanagementsystem.entities.Copy;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.repository.CopyRepository;
import com.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CopyServiceImpl implements CopyService {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository bookRepository;



    @Override
    public List<Copy> findAll() {
        return copyRepository.findAll();
    }

    @Override
    public Optional<Copy> findById(Long id) {
        return copyRepository.findById(id);
    }

    @Override
    public Copy save(Copy copy) {
        return copyRepository.save(copy);
    }

    @Transactional
    public CopyDTO createCopy(CopyDTO copyDTO) {
        Copy copy = new Copy();
        copy.setStatus(copyDTO.getStatus());
        // Assuming you have a method in CopyRepository to find a Book by ID
        Optional<Book> book = bookRepository.findById(copyDTO.getBookId());
        if(book.isPresent()){
            copy.setBook(book.get());
        }

        Copy savedCopy = copyRepository.save(copy);
        // Direct mapping from Copy entity to CopyDTO
        CopyDTO savedCopyDTO = new CopyDTO();
        savedCopyDTO.setId(savedCopy.getId());
        savedCopyDTO.setStatus(savedCopy.getStatus());
        savedCopyDTO.setBookId(savedCopy.getBook().getId()); // Assuming CopyDTO has a field bookId

        return savedCopyDTO;
    }



    @Override
    public void deleteById(Long id) {
        copyRepository.deleteById(id);
    }

    @Transactional
    public List<CopyDTO> findCopiesByBookId(Long bookId) {
        List<Copy> copies = copyRepository.findByBookId(bookId); // Assuming CopyRepository has findByBookId method

        // Map Copy entities to CopyDTOs
        List<CopyDTO> copyDTOs = copies.stream()
                .map(this::mapCopyToCopyDTO) // Using method reference for mapping
                .collect(Collectors.toList());

        return copyDTOs;
    }

    @Transactional
    public CopyDTO updateCopy(Long id, CopyDTO copyDTO) {
        Optional<Copy> optionalCopy = copyRepository.findById(id);

        if (optionalCopy.isPresent()) {
            Copy copy = optionalCopy.get();
            copy.setStatus(copyDTO.getStatus()); // Update status from CopyDTO

            // Save the updated copy entity
            copy = copyRepository.save(copy);

            // Map the updated copy entity back to CopyDTO
            CopyDTO updatedCopyDTO = mapCopyToCopyDTO(copy);
            return updatedCopyDTO;
        } else {
            return null;
        }
    }


    private CopyDTO mapCopyToCopyDTO(Copy copy) {
        CopyDTO copyDTO = new CopyDTO();
        copyDTO.setId(copy.getId());
        copyDTO.setStatus(copy.getStatus());
        // Assuming CopyDTO has a field bookId and you want to retrieve bookId from copy
        copyDTO.setBookId(copy.getBook().getId());
        return copyDTO;
    }
}
