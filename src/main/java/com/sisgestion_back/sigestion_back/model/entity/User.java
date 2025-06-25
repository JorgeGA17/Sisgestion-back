package com.sisgestion_back.sigestion_back.model.entity;

import com.sisgestion_back.sigestion_back.Audit.Config.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User  extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_pk")
    private Long userPk;

    @Column(name = "x_correo_institucional", nullable = false, unique = true)
    private String xcorreoInstitucional;

    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Personal personal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id", referencedColumnName = "role_pk")
    private Role role;

}
