package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;

import java.util.List;

public interface AddressService {
    List<AddressTO> getAllAddresses();
    AddressTO getAddressById(Long id);
    AddressTO createAddress(AddressTO addressTO);
    AddressTO updateAddress(Long id, AddressTO addressTO);
    void deleteAddress(Long id);
}
