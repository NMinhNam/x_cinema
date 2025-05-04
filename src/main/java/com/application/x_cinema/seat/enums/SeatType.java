package com.application.x_cinema.seat.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeatType {
    STANDARD("standard"),
    VIP("VIP"),
    LUXURY("luxury"),
    BEAN_BAG("bean bag"),
    ROCKING_CHAIR("rocking chair");

    private final String value;


    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static SeatType fromValue(String value) {
        for (SeatType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid seat type: " + value);
    }
}
