package spring.study.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// MemoryDbEntity를 상속받은 제네릭 타입 T를 받는 추상 클래스
public abstract class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0; // Primary Key에 반영할 Auto Increment 역할

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(t -> t.getIndex() == index) // MemoryDbEntity를 상속받은 제네릭 T는 getIndex() 메서드를 사용할 수 있다.
            .findFirst();
    }

    @Override
    public T save(T entity) {

        var optionalEntity = db.stream().filter(t -> t.getIndex() == entity.getIndex())
            .findFirst();

        if (optionalEntity.isEmpty()) { // DB에 데이터가 없는 경우

            entity.setIndex(++index);
            db.add(entity); // 데이터 저장
        }
        else { // DB에 이미 데이터가 있는 경우
            var preIndex = optionalEntity.get().getIndex();

            this.deleteById(preIndex); // 기존에 있던 데이터를 지우고

            entity.setIndex(preIndex); // 기존 ID를 반영
            db.add(entity); // 새 데이터를 넣어준다.
        }

        return entity;
    }

    @Override
    public void deleteById(int index) {

        var optionalEntity = db.stream().filter(t -> t.getIndex() == index)
            .findFirst();

        optionalEntity.ifPresent(db::remove);
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
