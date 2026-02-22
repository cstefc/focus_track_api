package be.osse.focus_track_api.domain.general;

import be.osse.focus_track_api.domain.predefined.ReferenceType;
import jakarta.persistence.*;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private ReferenceType refType;

    private long refId;

    public ReferenceType getRefType() {
        return refType;
    }

    public void setRefType(ReferenceType refType) {
        this.refType = refType;
    }

    public long getId() {
        return id;
    }

    public long getRefId() {
        return refId;
    }

    public void setRefId(long refId) {
        this.refId = refId;
    }
}
