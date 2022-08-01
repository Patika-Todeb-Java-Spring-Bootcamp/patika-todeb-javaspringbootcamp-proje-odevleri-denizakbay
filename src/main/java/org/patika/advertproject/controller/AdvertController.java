package org.patika.advertproject.controller;

import lombok.RequiredArgsConstructor;
import org.patika.advertproject.model.dto.AdvertDTO;
import org.patika.advertproject.model.entity.Advert;
import org.patika.advertproject.service.AdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/advert")
public class AdvertController {

    private final AdvertService advertService;


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @GetMapping("/all")
    public List<Advert> getAllAdverts() {
        return advertService.getAll();
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity getAdvertById(@PathVariable("id") Long id){
        Advert advert = advertService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(advert);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity addAdvert(@RequestBody AdvertDTO advertDTO) {
         Advert advert = advertService.createAdvert(advertDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(advert);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdvert(@PathVariable("id") Long id){
        advertService.deleteAdvert(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Advert deleted id= "+id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAdvert(@PathVariable("id") Long id, @RequestBody AdvertDTO advertDTO){
       Advert advert = advertService.update(id, advertDTO);
       return ResponseEntity.status(HttpStatus.OK).body(advert);
    }

}
