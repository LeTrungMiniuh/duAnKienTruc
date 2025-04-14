package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.request.CategoryRequest;
import Spring_AdamStore.dto.response.CategoryResponse;
import Spring_AdamStore.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:15:09+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        if ( request.getDescription() != null ) {
            category.description( request.getDescription() );
        }
        if ( request.getName() != null ) {
            category.name( request.getName() );
        }

        return category.build();
    }

    @Override
    public CategoryResponse toCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponse.CategoryResponseBuilder categoryResponse = CategoryResponse.builder();

        if ( category.getCreatedAt() != null ) {
            categoryResponse.createdAt( category.getCreatedAt() );
        }
        if ( category.getCreatedBy() != null ) {
            categoryResponse.createdBy( category.getCreatedBy() );
        }
        if ( category.getDescription() != null ) {
            categoryResponse.description( category.getDescription() );
        }
        if ( category.getId() != null ) {
            categoryResponse.id( category.getId() );
        }
        if ( category.getName() != null ) {
            categoryResponse.name( category.getName() );
        }
        if ( category.getStatus() != null ) {
            categoryResponse.status( category.getStatus() );
        }
        if ( category.getUpdatedAt() != null ) {
            categoryResponse.updatedAt( category.getUpdatedAt() );
        }
        if ( category.getUpdatedBy() != null ) {
            categoryResponse.updatedBy( category.getUpdatedBy() );
        }

        return categoryResponse.build();
    }

    @Override
    public void update(Category category, CategoryRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getDescription() != null ) {
            category.setDescription( request.getDescription() );
        }
        if ( request.getName() != null ) {
            category.setName( request.getName() );
        }
    }

    @Override
    public List<CategoryResponse> toCategoryResponseList(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryResponse> list = new ArrayList<CategoryResponse>( categories.size() );
        for ( Category category : categories ) {
            list.add( toCategoryResponse( category ) );
        }

        return list;
    }

    @Override
    public EntityBasic toEntityBasic(Category category) {
        if ( category == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        if ( category.getId() != null ) {
            entityBasic.id( category.getId() );
        }
        if ( category.getName() != null ) {
            entityBasic.name( category.getName() );
        }

        return entityBasic.build();
    }
}
