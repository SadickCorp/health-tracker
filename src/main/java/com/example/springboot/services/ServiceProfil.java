package com.example.springboot.services;

import com.example.springboot.beans.Profil;
import com.example.springboot.dto.light.LightProfilDto;
import com.example.springboot.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ServiceProfil implements IServiceProfil{

    private ProfilRepository profilRepository;

    public ServiceProfil(ProfilRepository profilRepository)
    {
        this.profilRepository = profilRepository;
    }
    public Profil getProfil(long id) {
        return this.profilRepository.findById(id).get();
    }

    public Profil addProfil(Profil pprofil) {
        return this.repository.saveAndFlush(pprofil);
    }

    public Profil updateProfil(long id, LightProfilDto lightProfilDto) {
        Profil pprofil = this.getProfil(id);
        pprofil.update(lightProfilDto);

        return this.repository.saveAndFlush(pprofil);
    }

    public void deleteProfil(long id) {
        this.profilRepository.deleteById(id);
    }

    public List<Profil> getProfils(){
        return profilRepository.findAll();
    }
}
