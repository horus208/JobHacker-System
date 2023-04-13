package mappers;

import java.util.List;

public interface Mapper<T> {
    T map(List<String> args);
}
