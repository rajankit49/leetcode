//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
  public:
    vector<int> duplicates(int arr[], int n) {
        // code here
        int i;
        sort(arr,arr+n);
        vector<int> ans;
        for(i=1;i<n;i++)
        {
            if(arr[i]==arr[i-1])
            {
                if(ans.size()==0)
                ans.push_back(arr[i]);
                else if(ans[ans.size()-1]!=arr[i])
                {
                    ans.push_back(arr[i]);
                }
            }
        }
        if(ans.size()==0)
        ans.push_back(-1);
        return ans;
    
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) cin >> a[i];
        Solution obj;
        vector<int> ans = obj.duplicates(a, n);
        for (int i : ans) cout << i << ' ';
        cout << endl;
    }
    return 0;
}

// } Driver Code Ends