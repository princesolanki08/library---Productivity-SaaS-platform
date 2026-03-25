//package com.selfstudy.library.dto;
//
//import lombok.*;
//
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor
//public class FeedbackDTO {
//    private Long id;
//    private Long userId;
//    private String message;
//    private LocalDateTime submittedAt;
//}


package com.selfstudy.library.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {

    private Long id;
    private String message;
    private LocalDateTime submittedAt;
    private Long userId;

}