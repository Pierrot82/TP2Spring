package com.inti.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.inti.model.Client;
import com.inti.model.Responsable;
import com.inti.model.Salarie;
import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUtilisateurRepository iUtilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = iUtilisateurRepository.findByUsername(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé: " + username);
        }

        String role = getRole(utilisateur);

        return User.withUsername(utilisateur.getUsername())
                .password(utilisateur.getPassword())
                .roles(role)
                .build();
    }

    private String getRole(Utilisateur utilisateur) {
        if (utilisateur instanceof Responsable) {
            return "RESPONSABLE";
        } else if (utilisateur instanceof Salarie) {
            return "SALARIE";
        } else if (utilisateur instanceof Client) {
            return "CLIENT";
        }
        return "";
    }
}