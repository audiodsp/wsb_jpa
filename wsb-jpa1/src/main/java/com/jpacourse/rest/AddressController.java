package com.jpacourse.rest;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.mapper.AddressMapper;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.AddressService;
import com.jpacourse.service.impl.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl addressService;
    private final AddressMapper addressMapper;

    @GetMapping("/{id}")
    AddressTO findBaId(@PathVariable final Long id) {
        final AddressTO address = addressService.findById(id);
        if (address != null) {
            return address;
        }
        throw new EntityNotFoundException(id);
    }
}
