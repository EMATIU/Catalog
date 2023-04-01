package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SubjectName {
    ENGLISH("English"),
    MATH("Math"),
    PHYSICS("Physics"),
    COMPUTER_SCIENCE("Computer science"),
    HISTORY("History"),
    GEOGRAPHY("Geography"),
    ART("Art"),
    NONE("None"); // in cazul in care nu este niciun field

    private final String typeString;

    public static SubjectName getEnumByFieldString(String field) {
        return Arrays.stream(SubjectName.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
