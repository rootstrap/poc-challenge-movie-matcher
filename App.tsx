import React from 'react';
import { Provider as PaperProvider } from 'react-native-paper';

import { NavigationContainer } from '@react-navigation/native';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

import NavigationStack from 'navigation/index';

import { DEFAULT_THEME } from 'theme/index';

const queryClient = new QueryClient();

const App = () => {
  return (
    <QueryClientProvider client={queryClient}>
      <PaperProvider theme={DEFAULT_THEME}>
        <NavigationContainer>
          <NavigationStack />
        </NavigationContainer>
      </PaperProvider>
    </QueryClientProvider>
  );
};

export default App;
