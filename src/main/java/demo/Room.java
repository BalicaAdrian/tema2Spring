package demo;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="numberOfSeats", nullable = false)
    private long numberOfSeats;

    @OneToMany(targetEntity = Track.class, fetch = FetchType.EAGER, mappedBy = "room")
    private Set<Track> tracks;

    public long getId() {
        return id;
    }

    public Room() {}

    public Room(String name, Long numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() { return name; }
    public long getNrOfSeats() { return numberOfSeats; }

    public Set<Track> getTracks() { return tracks; }

    public void setName(String name) { this.name = name; }
    public void setSeats(long seats) { this.numberOfSeats = seats; }

    public void setTracks(Set<Track> tracks) { this.tracks = tracks; }

    public void addTrack(Track track) { tracks.add(track);}

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    public void update(Room room) {
        this.name = room.getName();
        this.numberOfSeats = room.getNrOfSeats();
    }
}
