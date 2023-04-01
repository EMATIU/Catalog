package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Semester {
    FIRST_SEMESTER("First semester"),
    SECOND_SEMESTER("Second semester"),
    NONE("None"); // in cazul in care nu este niciun field

    private final String typeString;

    public static Semester getEnumByFieldString(String field) {
        return Arrays.stream(Semester.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
