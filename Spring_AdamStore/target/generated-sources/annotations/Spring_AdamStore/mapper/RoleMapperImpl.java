package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.response.RoleResponse;
import Spring_AdamStore.entity.Role;
import Spring_AdamStore.entity.relationship.RoleHasPermission;
import Spring_AdamStore.entity.relationship.UserHasRole;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:15:09+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public RoleResponse toRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse.RoleResponseBuilder roleResponse = RoleResponse.builder();

        Set<EntityBasic> set = roleHasPermissionSetToEntityBasicSet( role.getPermissions() );
        if ( set != null ) {
            roleResponse.permissions( set );
        }
        if ( role.getDescription() != null ) {
            roleResponse.description( role.getDescription() );
        }
        if ( role.getId() != null ) {
            roleResponse.id( role.getId() );
        }
        if ( role.getName() != null ) {
            roleResponse.name( role.getName() );
        }

        return roleResponse.build();
    }

    @Override
    public List<RoleResponse> toRoleResponseList(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleResponse> list = new ArrayList<RoleResponse>( roles.size() );
        for ( Role role : roles ) {
            list.add( toRoleResponse( role ) );
        }

        return list;
    }

    @Override
    public EntityBasic userHasRoleToEntityBasic(UserHasRole userHasRole) {
        if ( userHasRole == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        Long id = userHasRoleRoleId( userHasRole );
        if ( id != null ) {
            entityBasic.id( id );
        }
        String name = userHasRoleRoleName( userHasRole );
        if ( name != null ) {
            entityBasic.name( name );
        }

        return entityBasic.build();
    }

    @Override
    public Set<EntityBasic> userHasRoleToEntityBasicSet(Set<UserHasRole> userHasRoleSet) {
        if ( userHasRoleSet == null ) {
            return null;
        }

        Set<EntityBasic> set = new LinkedHashSet<EntityBasic>( Math.max( (int) ( userHasRoleSet.size() / .75f ) + 1, 16 ) );
        for ( UserHasRole userHasRole : userHasRoleSet ) {
            set.add( userHasRoleToEntityBasic( userHasRole ) );
        }

        return set;
    }

    protected Set<EntityBasic> roleHasPermissionSetToEntityBasicSet(Set<RoleHasPermission> set) {
        if ( set == null ) {
            return null;
        }

        Set<EntityBasic> set1 = new LinkedHashSet<EntityBasic>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleHasPermission roleHasPermission : set ) {
            set1.add( permissionMapper.roleHasPermissionToEntityBasic( roleHasPermission ) );
        }

        return set1;
    }

    private Long userHasRoleRoleId(UserHasRole userHasRole) {
        if ( userHasRole == null ) {
            return null;
        }
        Role role = userHasRole.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String userHasRoleRoleName(UserHasRole userHasRole) {
        if ( userHasRole == null ) {
            return null;
        }
        Role role = userHasRole.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
