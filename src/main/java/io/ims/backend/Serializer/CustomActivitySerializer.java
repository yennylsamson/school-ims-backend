package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Professor;
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

        generator.writeStartObject();
        generator.writeNumberField("activityID", activity.getActivityID());
        generator.writeStringField("activityName", activity.getActivityName());
        generator.writeStringField("activityType", activity.getActivityType());
        generator.writeNumberField("studentScore", activity.getStudentScore());
        generator.writeNumberField("totalScore", activity.getTotalScore());
        generator.writeFieldName("students");
            Student student = activity.getStudent();
            generator.writeStartObject();
                generator.writeNumberField("userID", student.getUserID());
                generator.writeStringField("firstName", student.getFirstName());
                generator.writeStringField("lastName", student.getLastName());
                generator.writeStringField("courseName", student.getCourse().getCourseName());
                generator.writeStringField("yearLevel", student.getYearLevel());
                generator.writeStringField("section", student.getSection());
            generator.writeEndObject();
        generator.writeFieldName("professor");
            Professor professor = activity.getProfessor();
            generator.writeStartObject();
                generator.writeNumberField("userID", professor.getUserID());
                generator.writeStringField("firstName", professor.getFirstName());
                generator.writeStringField("lastName", professor.getLastName());
                generator.writeStringField("departmentName", professor.getDepartment().getDepartmentName());
            generator.writeEndObject();
        generator.writeEndObject();
    }
}
