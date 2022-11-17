import { DefaultTheme } from 'react-native-paper';

import { BLACK, PRIMARY_COLOR, SCREEN_BACKGROUND } from 'constants/colors';

export const DEFAULT_THEME = {
  ...DefaultTheme,
  colors: {
    ...DefaultTheme.colors,
    primary: PRIMARY_COLOR,
    text: BLACK,
    background: SCREEN_BACKGROUND,
  },
};
