package com.example.springboot.services;

import com.example.springboot.beans.Profil;
import com.example.springboot.dto.light.LightProfilDto;
import com.example.springboot.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service()
public class ServiceProfil implements IServiceProfil{

    private final ProfilRepository profilRepository;

    public ServiceProfil(ProfilRepository profilRepository)
    {
        this.profilRepository = profilRepository;
    }
    public Profil getProfil(UUID id) {
        return this.profilRepository.findById(id).orElse(null);
    }

    public Profil getProfilByUserId(UUID id){
        return this.profilRepository.findProfilByUserId(id);
    }

    public Profil addProfil(Profil pprofil) {
        return this.profilRepository.saveAndFlush(pprofil);
    }

    public Profil updateProfil(UUID id, LightProfilDto lightProfilDto) {
        Profil pprofil = this.getProfil(id);
        pprofil.update(lightProfilDto);

        return this.profilRepository.saveAndFlush(pprofil);
    }

    public void deleteProfil(UUID id) {
        this.profilRepository.deleteById(id);
    }

    public List<Profil> getProfils(){
        return profilRepository.findAll();
    }
}
