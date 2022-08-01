package org.patika.advertproject.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.patika.advertproject.model.dto.AdvertDTO;
import org.patika.advertproject.model.entity.Advert;
import org.patika.advertproject.model.mapper.AdvertMapper;
import org.patika.advertproject.repository.AdvertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;


    public List<Advert> getAll() {
        return advertRepository.findAll();
    }

    public Advert createAdvert(AdvertDTO advertDTO) {
        Advert advert = AdvertMapper.toEntity(advertDTO);
        return advertRepository.save(advert);
    }

    public Advert findById(Long id) {
        return advertRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("cannot find advert by id = "+id));
    }

    public void deleteAdvert(Long id) {
        findById(id);
        advertRepository.deleteById(id);
    }

    public Advert update(Long id, AdvertDTO advertDTO) {
        Advert advert = findById(id);
        if(StringUtils.isNotEmpty(advertDTO.getTitle())){
            advert.setTitle(advertDTO.getTitle());
        }
        if(StringUtils.isNotEmpty(advertDTO.getDescription())){
            advert.setDescription(advertDTO.getDescription());
        }
        if(Objects.nonNull(advertDTO.getPrice()) || advertDTO.getPrice() > 0 ){
            advert.setPrice(advertDTO.getPrice());
        }
       return advertRepository.save(advert);
    }
}
