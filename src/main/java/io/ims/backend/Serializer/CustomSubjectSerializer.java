package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Student;
import io.ims.backend.Models.Subject;

import java.io.IOException;

public class CustomSubjectSerializer extends StdSerializer<Subject> {
    public CustomSubjectSerializer() {
        this(null);
    }

    public CustomSubjectSerializer(Class<Subject> t) {
        super(t);
    }


    @Override
    public void serialize(
            Subject subject,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        subject.setDepartment(null);
        subject.setEnrolledStudents(null);
        subject.setTeachingProfessors(null);

        generator.writeObject(subject);
    }
}
