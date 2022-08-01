package org.patika.advertproject.model.mapper;

import org.patika.advertproject.model.dto.AdvertDTO;
import org.patika.advertproject.model.entity.Advert;

public class AdvertMapper {

    public static Advert toEntity(AdvertDTO advertDTO){
        Advert advert = new Advert();
        advert.setTitle(advertDTO.getTitle());
        advert.setDescription(advertDTO.getDescription());
        advert.setCategory(advertDTO.getCategory());
        advert.setNo(advertDTO.getNo());
        advert.setPrice(advertDTO.getPrice());
        advert.setPriceCurrency(advertDTO.getPriceCurrency());
        advert.setAddress(advertDTO.getAddress());
        advert.setRoom(advertDTO.getRoom());
        advert.setSqm(advertDTO.getSqm());
        advert.setFloorCount(advertDTO.getFloorCount());
        advert.setAge(advertDTO.getAge());

        return advert;
    }

}
