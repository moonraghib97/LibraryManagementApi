    package com.librarymanagementsystem.service;

    import com.librarymanagementsystem.dto.CopyDTO;
    import com.librarymanagementsystem.entities.Copy;

    import java.util.List;
    import java.util.Optional;

    public interface CopyService {

        List<Copy> findAll();

        Optional<Copy> findById(Long id);

        Copy save(Copy copy);

        CopyDTO createCopy(CopyDTO copyDTO);

        void deleteById(Long id);

        List<CopyDTO> findCopiesByBookId(Long bookId);
        CopyDTO updateCopy(Long id, CopyDTO copyDTO);
}
