package spring.study.restaurant.wishlist.dto;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import spring.study.restaurant.wishlist.entity.WishListEntity;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface WishListDtoMapper {

    WishListDto of(WishListEntity entity);
    WishListEntity of(WishListDto dto);
}
