package com.srjons.restentity.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int employeeId;

  private String employeeName;

  // MAPPING_CODE

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  private Date modifiedOn;
}
