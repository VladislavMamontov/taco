package springinaction.tacocloud.converter;

import springinaction.tacocloud.domain.Type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {
    @Override
    public String convertToDatabaseColumn(Type attribute) {
        return Optional.ofNullable(attribute)
                .map(Type::name)
                .orElse(null);
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Type.valueOf(dbData);
    }
}
