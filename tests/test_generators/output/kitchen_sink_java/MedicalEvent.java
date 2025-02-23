package org.sink.kitchen;

import java.util.List;
import lombok.*;

/**
  None
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class MedicalEvent extends Event {

  private Place inLocation;
  private DiagnosisConcept diagnosis;
  private ProcedureConcept procedure;

}