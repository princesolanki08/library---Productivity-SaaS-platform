package com.selfstudy.library.services;

import com.selfstudy.library.dto.OrganizationDTO;
import com.selfstudy.library.dto.AuthRequest;
import com.selfstudy.library.dto.AuthResponse;
import com.selfstudy.library.utils.JwtUtil;
import com.selfstudy.library.entities.Organization;
import com.selfstudy.library.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
	
	@Autowired
	private JwtUtil jwtUtil;

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationDTO createOrganization(OrganizationDTO dto) {

        Organization org = new Organization();
        org.setName(dto.getName());
        org.setUsername(dto.getUsername());
        org.setPassword(dto.getPassword());
        org.setUniqueOrganizationId(dto.getUniqueOrganizationId());
        org.setTotalSeats(dto.getTotalSeats());
        org.setAvailableSeats(dto.getAvailableSeats());

        Organization savedOrg = organizationRepository.save(org);

        return new OrganizationDTO(
                savedOrg.getId(),
                savedOrg.getName(),
                savedOrg.getUniqueOrganizationId(),
                savedOrg.getTotalSeats(),
                savedOrg.getAvailableSeats(),
                savedOrg.getUsername(),
                savedOrg.getPassword()
        );
    }

    public List<OrganizationDTO> getAllOrganizations() {
        return organizationRepository.findAll().stream()
                .map(org -> new OrganizationDTO(
                        org.getId(),
                        org.getName(),
                        org.getUniqueOrganizationId(),
                        org.getTotalSeats(),
                        org.getAvailableSeats(),
                        org.getUsername(),
                        org.getPassword()
                ))
                .collect(Collectors.toList());
    }
    
    public AuthResponse login(AuthRequest request) {

        Organization org = organizationRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Organization not found"));

        if (!org.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(org.getUsername());

        return new AuthResponse(token);
    }
}