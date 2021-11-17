package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Student;

import java.io.IOException;

public class CustomActivitySerializer extends StdSerializer<Activity> {
    public CustomActivitySerializer() {
        this(null);
    }

    public CustomActivitySerializer(Class<Activity> t) {
        super(t);
    }


    @Override
    public void serialize(
            Activity activity,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        activity.setStudent(null);
        activity.setProfessor(null);

        generator.writeObject(activity);
    }
}
