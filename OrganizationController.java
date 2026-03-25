package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.AuthRequest;
import com.selfstudy.library.dto.AuthResponse;
import com.selfstudy.library.dto.OrganizationDTO;
import java.util.stream.Collectors;
import com.selfstudy.library.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public OrganizationDTO createOrganization(@RequestBody OrganizationDTO dto) {
        return organizationService.createOrganization(dto);
    }

    @GetMapping
    public List<OrganizationDTO> getOrganizations() {
        return organizationService.getAllOrganizations();
    }
//    public List<OrganizationDTO> getAllOrganizations() {
//        return OrganizationDTO.findAll().stream()
//                .map(org -> new OrganizationDTO(
//                        org.getId(),
//                        org.getName(),
//                        org.getUniqueOrganizationId(),
//                        org.getTotalSeats(),
//                        org.getAvailableSeats(),
//                        org.getUsername(),
//                        org.getPassword()
//                ))
//                .collect(Collectors.toList());
//    }
    
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return organizationService.login(request);
    }
}
