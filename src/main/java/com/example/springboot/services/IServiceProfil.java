package com.example.springboot.services;

import com.example.springboot.beans.Profil;
import com.example.springboot.dto.light.LightProfilDto;

import java.util.UUID;

public interface IServiceProfil {
    public Profil getProfil(final UUID id);
    public Profil addProfil(final Profil pprofil);
    public Profil updateProfilByUserId(UUID id, final LightProfilDto lightProfilDto);
    public void deleteProfil(final UUID id);
}
