package com.reserve.core.entity.user;

import com.reserve.core.entity.BaseEntity;
import com.reserve.core.entity.user.enums.FileType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user_file")
public class UserFile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userFileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private FileType fileType;
    private String filePath;
    private Boolean isRepresentation;
}