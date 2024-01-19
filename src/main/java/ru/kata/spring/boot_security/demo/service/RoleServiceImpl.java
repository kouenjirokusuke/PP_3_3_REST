package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl (final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    @Transactional
    public Set<Role> getAllRoles() {
        Iterable<Role> iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(set::add);

        return set;
    }

    @Override
    @Transactional
    public void addNewRole(Role role) {
        roleRepository.save(role);
    }

}
