package io.ims.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Department;
import io.ims.backend.Models.Professor;
import io.ims.backend.Models.Subject;

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

        generator.writeStartObject();
            generator.writeNumberField("userID", professor.getUserID());
            generator.writeStringField("email", professor.getEmail());
            generator.writeStringField("password", professor.getPassword());
            generator.writeStringField("userRole", professor.getUserRole());
            generator.writeStringField("firstName", professor.getFirstName());
            generator.writeStringField("lastName", professor.getLastName());
            generator.writeStringField("gender", professor.getGender());
            generator.writeStringField("birthDate", professor.getBirthDate().toString());
            generator.writeStringField("homeAddress", professor.getHomeAddress());
            generator.writeStringField("contactNumber", professor.getContactNumber());
            generator.writeStringField("civilStatus", professor.getCivilStatus());
            generator.writeFieldName("joinedProfessorSubjects");
                generator.writeStartArray();
                    for (Subject subject : professor.getJoinedProfessorSubjects()) {
                        generator.writeStartObject();
                            generator.writeNumberField("subjectID", subject.getSubjectID());
                            generator.writeStringField("subjectName", subject.getSubjectName());
                            generator.writeStringField("subjectCode", subject.getSubjectCode());
                            generator.writeStringField("units", subject.getUnits());
                            generator.writeNumberField("lectureHours", subject.getLectureHours());
                            generator.writeNumberField("labHours", subject.getLabHours());
                            generator.writeStringField("departmentName", subject.getDepartment().getDepartmentName());
                        generator.writeEndObject();
                    }
                generator.writeEndArray();
        generator.writeFieldName("activities");
            generator.writeStartArray();
                for (Activity activity : professor.getActivities()) {
                    generator.writeStartObject();
                        generator.writeNumberField("activityID", activity.getActivityID());
                        generator.writeStringField("subjectName", activity.getSubject().getSubjectName());
                        generator.writeStringField("activityName", activity.getActivityName());
                        generator.writeStringField("activityType", activity.getActivityType());
                        generator.writeNumberField("studentScore", activity.getStudentScore());
                        generator.writeNumberField("totalScore", activity.getTotalScore());
                        generator.writeStringField("studentName", activity.getStudent().getFirstName() + " " + activity.getStudent().getLastName());
                        generator.writeStringField("professorName", activity.getProfessor().getFirstName() + " " + activity.getProfessor().getLastName());
                    generator.writeEndObject();
                }
            generator.writeEndArray();
        generator.writeFieldName("department");
            Department department = professor.getDepartment();
            generator.writeStartObject();
                generator.writeNumberField("departmentID", department.getDepartmentID());
                generator.writeStringField("departmentName", department.getDepartmentName());
                generator.writeStringField("departmentDean", department.getDepartmentDean());
            generator.writeEndObject();

        generator.writeEndObject();
    }
}
