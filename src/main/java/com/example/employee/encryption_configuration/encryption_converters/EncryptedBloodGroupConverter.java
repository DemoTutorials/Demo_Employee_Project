package com.example.employee.encryption_configuration.encryption_converters;

import com.example.employee.encryption_configuration.encryption_util.EncryptionUtil;
import com.example.employee.enums.BloodGroup;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EncryptedBloodGroupConverter implements AttributeConverter<BloodGroup,String> {
    @Override
    public String convertToDatabaseColumn(BloodGroup attribute) {
        try {
            return attribute==null?null: EncryptionUtil.encrypt(attribute.name());
        } catch (Exception e) {
            throw new RuntimeException("BloodGroup Failed to encrypt"+e);
        }
    }

    @Override
    public BloodGroup convertToEntityAttribute(String dbData) {
       if(dbData==null)
           return null;
        try {
            String decrypt = EncryptionUtil.decrypt(dbData);
            return BloodGroup.valueOf(decrypt);
        } catch (Exception e) {
            throw new RuntimeException("BloodGroup Failed to decrypt"+e);
        }
    }
}
