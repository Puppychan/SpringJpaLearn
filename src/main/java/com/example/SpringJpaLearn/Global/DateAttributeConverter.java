package com.example.SpringJpaLearn.Global;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.util.Date;

@Converter(autoApply = true)
public class DateAttributeConverter implements AttributeConverter<Date, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(Date date) {
        return date == null? null : new Timestamp(date.getTime());
    }

    @Override
    public Date convertToEntityAttribute(Timestamp timestamp) {
        return timestamp == null? null : new Date(timestamp.getTime());
    }
}
