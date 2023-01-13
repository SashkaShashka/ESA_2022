package com.example.lab_4_andreev_zaimov.service;

import com.example.lab_4_andreev_zaimov.model.Owner;
import com.example.lab_4_andreev_zaimov.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AuditService auditService;

    public Owner findById(Long id){

        return ownerRepository.findById(id).orElseThrow();
    }

    public Owner create(Owner owner) {
        ownerRepository.saveAndFlush(owner);

        auditService.log(owner, "owner", AuditService.EVENT_CREATE);

        return owner;
    }

    public Owner update(Owner owner){
        Owner ownerOld = ownerRepository.findById(owner.getAnimal_owner_id()).orElseThrow();

        auditService.log(ownerOld, owner, "owner", AuditService.EVENT_UPDATE);

        return ownerRepository.saveAndFlush(owner);
    }

    public Owner delete(Long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow();
        ownerRepository.delete(owner);

        auditService.log(owner, "owner", AuditService.EVENT_DELETE);

        return owner;
    }

    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }
}
