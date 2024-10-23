package edu.iuhs.crm.modle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    String errorMessage;
    String status;


}
