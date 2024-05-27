package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.repository.AddressRepository;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(addressMapper::toTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressTO getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::toTO)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public AddressTO createAddress(AddressTO addressTO) {
        AddressEntity addressEntity = addressMapper.toEntity(addressTO);
        addressEntity = addressRepository.save(addressEntity);
        return addressMapper.toTO(addressEntity);
    }

    @Override
    public AddressTO updateAddress(Long id, AddressTO addressTO) {
        if (!addressRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        AddressEntity addressEntity = addressMapper.toEntity(addressTO);
        addressEntity.setId(id);
        addressEntity = addressRepository.save(addressEntity);
        return addressMapper.toTO(addressEntity);
    }

    @Override
    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        addressRepository.deleteById(id);
    }
}
