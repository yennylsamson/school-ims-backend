package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Professor;

import java.io.IOException;

public class CustomProfessorSerializer extends StdSerializer<Professor> {
    public CustomProfessorSerializer() {
        this(null);
    }

    public CustomProfessorSerializer(Class<Professor> t) {
        super(t);
    }


    @Override
    public void serialize(
            Professor professor,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        professor.setDepartment(null);
        professor.setJoinedProfessorSubjects(null);
        professor.setActivities(null);

        generator.writeObject(professor);
    }
}
