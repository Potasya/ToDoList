package entity.converters;

import javax.persistence.AttributeConverter;

/**
 * Created by Marisha on 31/10/16.
 */
public class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {

        public Integer convertToDatabaseColumn(Boolean aBoolean) {
            if (aBoolean == null) {
                return 0;
            }
            return aBoolean == true ? 1 : 0;
        }

        public Boolean convertToEntityAttribute(Integer integer) {
            if (integer == null) {
                return false;
            }
            return integer == 0 ? false : true;
        }
    }

