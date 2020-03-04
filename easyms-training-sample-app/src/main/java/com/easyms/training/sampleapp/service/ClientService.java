package com.easyms.training.sampleapp.service;

import com.easyms.training.sampleapp.model.dto.ClientDto;
import com.easyms.training.sampleapp.model.entity.Client;
import com.easyms.training.sampleapp.repository.ClientRepository;
import com.easyms.training.sampleapp.util.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Optional<ClientDto> getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        Optional<ClientDto> dto = Optional.ofNullable(ObjectMapperUtils.map(client.get(),ClientDto.class));
        return dto;


    }

    public List<ClientDto> getAll() {
        List<Client> clientList = clientRepository.findAll();
        return ObjectMapperUtils.mapAll(clientList, ClientDto.class);

    }
    public Client save(ClientDto dto) {

        return clientRepository.save(ObjectMapperUtils.map(dto,Client.class));
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}

