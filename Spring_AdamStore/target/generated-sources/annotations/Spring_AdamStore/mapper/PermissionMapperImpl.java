package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.response.PermissionResponse;
import Spring_AdamStore.entity.Permission;
import Spring_AdamStore.entity.relationship.RoleHasPermission;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:15:10+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public PermissionResponse toPermissionResponse(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionResponse.PermissionResponseBuilder permissionResponse = PermissionResponse.builder();

        if ( permission.getApiPath() != null ) {
            permissionResponse.apiPath( permission.getApiPath() );
        }
        if ( permission.getId() != null ) {
            permissionResponse.id( permission.getId() );
        }
        if ( permission.getMethod() != null ) {
            permissionResponse.method( permission.getMethod() );
        }
        if ( permission.getModule() != null ) {
            permissionResponse.module( permission.getModule() );
        }
        if ( permission.getName() != null ) {
            permissionResponse.name( permission.getName() );
        }

        return permissionResponse.build();
    }

    @Override
    public List<PermissionResponse> toPermissionResponseList(List<Permission> permissions) {
        if ( permissions == null ) {
            return null;
        }

        List<PermissionResponse> list = new ArrayList<PermissionResponse>( permissions.size() );
        for ( Permission permission : permissions ) {
            list.add( toPermissionResponse( permission ) );
        }

        return list;
    }

    @Override
    public EntityBasic roleHasPermissionToEntityBasic(RoleHasPermission roleHasPermission) {
        if ( roleHasPermission == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        Long id = roleHasPermissionPermissionId( roleHasPermission );
        if ( id != null ) {
            entityBasic.id( id );
        }
        String name = roleHasPermissionPermissionName( roleHasPermission );
        if ( name != null ) {
            entityBasic.name( name );
        }

        return entityBasic.build();
    }

    private Long roleHasPermissionPermissionId(RoleHasPermission roleHasPermission) {
        if ( roleHasPermission == null ) {
            return null;
        }
        Permission permission = roleHasPermission.getPermission();
        if ( permission == null ) {
            return null;
        }
        Long id = permission.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String roleHasPermissionPermissionName(RoleHasPermission roleHasPermission) {
        if ( roleHasPermission == null ) {
            return null;
        }
        Permission permission = roleHasPermission.getPermission();
        if ( permission == null ) {
            return null;
        }
        String name = permission.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
