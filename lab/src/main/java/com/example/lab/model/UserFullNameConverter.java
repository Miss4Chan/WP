package com.example.lab.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserFullNameConverter implements AttributeConverter<UserFullname, String>{
    private static final String SEPARATOR = ", ";
    @Override
    public String convertToDatabaseColumn(UserFullname userFullname) {
        if (userFullname == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        if (userFullname.getSurname() != null && !userFullname.getSurname()
                .isEmpty()) {
            sb.append(userFullname.getSurname());
            sb.append(SEPARATOR);
        }

        if (userFullname.getName() != null
                && !userFullname.getName().isEmpty()) {
            sb.append(userFullname.getName());
        }

        return sb.toString();
    }

    @Override
    public UserFullname convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        String[] pieces = s.split(SEPARATOR);

        if (pieces == null || pieces.length == 0) {
            return null;
        }

        UserFullname person = new UserFullname();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
        if (s.contains(SEPARATOR)) {
            person.setSurname(firstPiece);

            if (pieces.length >= 2 && pieces[1] != null
                    && !pieces[1].isEmpty()) {
                person.setName(pieces[1]);
            }
        } else {
            person.setName(firstPiece);
        }

        return person;
    }
}
