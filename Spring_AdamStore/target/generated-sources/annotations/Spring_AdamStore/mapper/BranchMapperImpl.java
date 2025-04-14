package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.request.BranchRequest;
import Spring_AdamStore.dto.request.BranchUpdateRequest;
import Spring_AdamStore.dto.response.BranchResponse;
import Spring_AdamStore.entity.Branch;
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
public class BranchMapperImpl implements BranchMapper {

    @Override
    public Branch toBranch(BranchRequest request) {
        if ( request == null ) {
            return null;
        }

        Branch.BranchBuilder branch = Branch.builder();

        if ( request.getLocation() != null ) {
            branch.location( request.getLocation() );
        }
        if ( request.getName() != null ) {
            branch.name( request.getName() );
        }
        if ( request.getPhone() != null ) {
            branch.phone( request.getPhone() );
        }

        return branch.build();
    }

    @Override
    public BranchResponse toBranchResponse(Branch branch) {
        if ( branch == null ) {
            return null;
        }

        BranchResponse.BranchResponseBuilder branchResponse = BranchResponse.builder();

        if ( branch.getCreatedAt() != null ) {
            branchResponse.createdAt( branch.getCreatedAt() );
        }
        if ( branch.getCreatedBy() != null ) {
            branchResponse.createdBy( branch.getCreatedBy() );
        }
        if ( branch.getId() != null ) {
            branchResponse.id( branch.getId() );
        }
        if ( branch.getLocation() != null ) {
            branchResponse.location( branch.getLocation() );
        }
        if ( branch.getName() != null ) {
            branchResponse.name( branch.getName() );
        }
        if ( branch.getPhone() != null ) {
            branchResponse.phone( branch.getPhone() );
        }
        if ( branch.getStatus() != null ) {
            branchResponse.status( branch.getStatus() );
        }
        if ( branch.getUpdatedAt() != null ) {
            branchResponse.updatedAt( branch.getUpdatedAt() );
        }
        if ( branch.getUpdatedBy() != null ) {
            branchResponse.updatedBy( branch.getUpdatedBy() );
        }

        return branchResponse.build();
    }

    @Override
    public void update(Branch branch, BranchUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getLocation() != null ) {
            branch.setLocation( request.getLocation() );
        }
        if ( request.getName() != null ) {
            branch.setName( request.getName() );
        }
        if ( request.getPhone() != null ) {
            branch.setPhone( request.getPhone() );
        }
    }

    @Override
    public List<BranchResponse> toBranchResponseList(List<Branch> branchList) {
        if ( branchList == null ) {
            return null;
        }

        List<BranchResponse> list = new ArrayList<BranchResponse>( branchList.size() );
        for ( Branch branch : branchList ) {
            list.add( toBranchResponse( branch ) );
        }

        return list;
    }
}
