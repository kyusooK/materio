package wizmokeycloak.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import wizmokeycloak.domain.*;
import wizmokeycloak.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CompanyCreated extends AbstractEvent {

    private String code;
    private String name;
    private String industry;
    private LocalDate foundedDate;
    private Long codeNum;

    public CompanyCreated(Company aggregate) {
        super(aggregate);
    }

    public CompanyCreated() {
        super();
    }
}
//>>> DDD / Domain Event
