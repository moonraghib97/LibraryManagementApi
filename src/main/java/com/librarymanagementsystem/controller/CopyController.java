package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.dto.CopyDTO;
import com.librarymanagementsystem.entities.Copy;
import com.librarymanagementsystem.service.CopyService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/copies")
public class CopyController {

    @Autowired
    private CopyService copyService;

    @GetMapping
    public ResponseEntity<List<Copy>> getAllCopies() {
        List<Copy> copies = copyService.findAll();
        return ResponseEntity.ok(copies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Copy> getCopyById(@PathVariable Long id) {
        Optional<Copy> byId = copyService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CopyDTO> createCopy(@Valid @RequestBody CopyDTO copyDTO) {
        CopyDTO createdCopyDTO = copyService.createCopy(copyDTO);
        return ResponseEntity.ok(createdCopyDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CopyDTO> updateCopy(@PathVariable Long id, @Valid @RequestBody CopyDTO copyDTO) {
        CopyDTO updatedCopyDTO = copyService.updateCopy(id, copyDTO);
        if (updatedCopyDTO != null) {
            return ResponseEntity.ok(updatedCopyDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCopy(@PathVariable Long id) {
        return copyService.findById(id)
                .map(copy -> {
                    copyService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<CopyDTO>> getCopiesByBookId(@PathVariable Long bookId) {
        List<CopyDTO> copies = copyService.findCopiesByBookId(bookId);
        return ResponseEntity.ok(copies);
    }
}
