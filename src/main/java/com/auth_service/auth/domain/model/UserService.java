package com.auth_service.auth.domain.model;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    public Map<String, String> getForm() {
        Map<String, String> form = new HashMap<>();
        form.put("Formulario",
                "https://docs.google.com/forms/d/e/1FAIpQLSclJ7f4My4atgQbvIY-2ANpCGqdA4p_E8qbcLdDqdByGbs1rQ/viewform");
        return form;

    }

}
