package com.edoc.ConsultationService.model;

import com.edoc.ConsultationService.Constants.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cs_user")
@Getter @Setter
public class User implements BaseModelObject {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String contact;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "doctorId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Consultation> consultations = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(userName, that.userName) && userType == that.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userType);
    }
}
