package com.example.springboot.controllers;


import com.example.springboot.beans.Profil;
import com.example.springboot.beans.User;
import com.example.springboot.dto.ProfilDto;
import com.example.springboot.dto.light.LightProfilDto;
import com.example.springboot.mappers.ProfilMapper;
import com.example.springboot.security.JwtProvider;
import com.example.springboot.services.ServiceProfil;
import com.example.springboot.services.ServiceUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/profil")
//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class ProfilController {
    private final ServiceProfil serviceProfil;
    private final ServiceUser serviceUser;
    private JwtProvider tokenProvider;
    public ProfilController(ServiceProfil serviceProfil, ServiceUser serviceUser,
                            JwtProvider tokenProvider){
        this.serviceProfil = serviceProfil;
        this.serviceUser = serviceUser;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping(value = "")
    public ResponseEntity<ProfilDto> create(@RequestBody LightProfilDto dto){
        Profil profil = ProfilMapper.INSTANCE.toBo(dto);
        User user = this.serviceUser.getUserById(dto.getUser_id());
        profil.setUser(user);
        profil = this.serviceProfil.addProfil(profil);
        ProfilDto profilDto = ProfilMapper.INSTANCE.toDto(profil);
        return ResponseEntity.ok(profilDto);
    }

    @GetMapping()
    public ResponseEntity<ProfilDto> findById(@RequestHeader (name="Authorization") String token){
        UUID idUser = tokenProvider.getUserIdFromJWT(token.substring(7, token.length()));
        Profil profil = this.serviceProfil.getProfilByUserId(idUser);
        ProfilDto dto = ProfilMapper.INSTANCE.toDto(profil);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ProfilDto> updateProfil(@PathVariable("id") UUID id, @RequestBody LightProfilDto lightProfilDto){
        Profil update = this.serviceProfil.updateProfil(id, lightProfilDto);
        ProfilDto profilDto = ProfilMapper.INSTANCE.toDto(update);
        return ResponseEntity.ok(profilDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProfil(@PathVariable("id") UUID id){
        this.serviceProfil.deleteProfil(id);
        return ResponseEntity.noContent().build();
    }
}
