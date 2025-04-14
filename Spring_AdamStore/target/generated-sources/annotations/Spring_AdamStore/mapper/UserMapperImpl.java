package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.basic.UserBasic;
import Spring_AdamStore.dto.request.RegisterRequest;
import Spring_AdamStore.dto.request.UserCreationRequest;
import Spring_AdamStore.dto.request.UserUpdateRequest;
import Spring_AdamStore.dto.response.UserResponse;
import Spring_AdamStore.entity.RedisPendingUser;
import Spring_AdamStore.entity.User;
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
    date = "2025-04-28T14:15:10+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User userCreationToUser(UserCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( request.getEmail() != null ) {
            user.email( request.getEmail() );
        }
        if ( request.getName() != null ) {
            user.name( request.getName() );
        }
        if ( request.getPassword() != null ) {
            user.password( request.getPassword() );
        }
        if ( request.getPhone() != null ) {
            user.phone( request.getPhone() );
        }

        return user.build();
    }

    @Override
    public RedisPendingUser registerToRedis(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        RedisPendingUser.RedisPendingUserBuilder redisPendingUser = RedisPendingUser.builder();

        if ( request.getEmail() != null ) {
            redisPendingUser.email( request.getEmail() );
        }
        if ( request.getName() != null ) {
            redisPendingUser.name( request.getName() );
        }
        if ( request.getPassword() != null ) {
            redisPendingUser.password( request.getPassword() );
        }
        if ( request.getPhone() != null ) {
            redisPendingUser.phone( request.getPhone() );
        }

        return redisPendingUser.build();
    }

    @Override
    public User redisToUser(RedisPendingUser redisPendingUser) {
        if ( redisPendingUser == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( redisPendingUser.getEmail() != null ) {
            user.email( redisPendingUser.getEmail() );
        }
        if ( redisPendingUser.getName() != null ) {
            user.name( redisPendingUser.getName() );
        }
        if ( redisPendingUser.getPassword() != null ) {
            user.password( redisPendingUser.getPassword() );
        }
        if ( redisPendingUser.getPhone() != null ) {
            user.phone( redisPendingUser.getPhone() );
        }

        return user.build();
    }

    @Override
    public void updateUser(User user, UserUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getAvatarUrl() != null ) {
            user.setAvatarUrl( request.getAvatarUrl() );
        }
        if ( request.getDob() != null ) {
            user.setDob( request.getDob() );
        }
        if ( request.getGender() != null ) {
            user.setGender( request.getGender() );
        }
        if ( request.getName() != null ) {
            user.setName( request.getName() );
        }
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        Set<EntityBasic> set = userHasRoleSetToEntityBasicSet( user.getRoles() );
        if ( set != null ) {
            userResponse.roles( set );
        }
        if ( user.getAvatarUrl() != null ) {
            userResponse.avatarUrl( user.getAvatarUrl() );
        }
        if ( user.getCreatedAt() != null ) {
            userResponse.createdAt( user.getCreatedAt() );
        }
        if ( user.getCreatedBy() != null ) {
            userResponse.createdBy( user.getCreatedBy() );
        }
        if ( user.getDob() != null ) {
            userResponse.dob( user.getDob() );
        }
        if ( user.getEmail() != null ) {
            userResponse.email( user.getEmail() );
        }
        if ( user.getGender() != null ) {
            userResponse.gender( user.getGender() );
        }
        if ( user.getId() != null ) {
            userResponse.id( user.getId() );
        }
        if ( user.getName() != null ) {
            userResponse.name( user.getName() );
        }
        if ( user.getPhone() != null ) {
            userResponse.phone( user.getPhone() );
        }
        if ( user.getStatus() != null ) {
            userResponse.status( user.getStatus() );
        }
        if ( user.getUpdatedAt() != null ) {
            userResponse.updatedAt( user.getUpdatedAt() );
        }
        if ( user.getUpdatedBy() != null ) {
            userResponse.updatedBy( user.getUpdatedBy() );
        }

        return userResponse.build();
    }

    @Override
    public List<UserResponse> toUserResponseList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        for ( User user : users ) {
            list.add( toUserResponse( user ) );
        }

        return list;
    }

    @Override
    public UserBasic toUserBasic(User user) {
        if ( user == null ) {
            return null;
        }

        UserBasic.UserBasicBuilder userBasic = UserBasic.builder();

        if ( user.getEmail() != null ) {
            userBasic.email( user.getEmail() );
        }
        if ( user.getId() != null ) {
            userBasic.id( user.getId() );
        }
        if ( user.getName() != null ) {
            userBasic.name( user.getName() );
        }
        if ( user.getPhone() != null ) {
            userBasic.phone( user.getPhone() );
        }

        return userBasic.build();
    }

    protected Set<EntityBasic> userHasRoleSetToEntityBasicSet(Set<UserHasRole> set) {
        if ( set == null ) {
            return null;
        }

        Set<EntityBasic> set1 = new LinkedHashSet<EntityBasic>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserHasRole userHasRole : set ) {
            set1.add( roleMapper.userHasRoleToEntityBasic( userHasRole ) );
        }

        return set1;
    }
}
