package ru.kata.spring.boot_security.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringToRolesConverter implements Converter<String, List<Role>> {

    private final RoleService roleService;

    public StringToRolesConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public List<Role> convert(String source) {
        List<Role> roles = new ArrayList<>();
        String[] rolesArray = source.substring(1, source.length() - 1).split(", ");

        for (String role : rolesArray) {
            roles.add(roleService.getRoleByName(role));
            System.out.println(roles.get(0).toString());
        }

        return roles;
    }
}
